//提示：下面的代码用jquery，所以如果有不能运行的情况请引用后尝试
//百度地图api container对应前端div名称 前端要引用2.0版本的百度地图api
//需引用api.map.baidu.com/library/AreaRestriction/1.2/src/AreaRestriction_min.js
var map = new BMap.Map("container");          // 创建地图实例

//var point = new BMap.Point(116.418261, 39.921984);//江苏
var point = new BMap.Point(112.979353,28.213478);//湖南
map.centerAndZoom(point, 8);             // 初始化地图，设置中心点坐标和地图级别
map.enableScrollWheelZoom(); // 允许滚轮缩放

map.enableDragging();//允许拖动
map.disableDoubleClickZoom();//禁止双击缩放
var blist = [];
var districtLoading = 0;

function getBoundary() {
    addDistrict("湖南");
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////
/**
 * 添加行政区划
 * @param {} districtName 行政区划名
 * @returns  无返回值
 */
function addDistrict(districtName) {
    //使用计数器来控制加载过程
    districtLoading++;
    var rs={"boundaries":["114.256424, 28.32422;.......]}//湖南边界经纬度太多，写一个json文件吧

        var count = rs.boundaries.length; //行政区域的点有多少个
    if (count === 0) {
        alert('未能获取当前输入行政区域');
        return;
    }
    for (var i = 0; i < count; i++) {
        blist.push({ points: rs.boundaries[i], name: districtName });
    };
    districtLoading--;
    if (districtLoading == 0) {
        //全加载完成后画端点
        drawBoundary();
    }
}
    function addDistrictsssssss(districtName) {
        //使用计数器来控制加载过程
        districtLoading++;
        var bdary = new BMap.Boundary();
        bdary.get(districtName, function (rs) {       //获取行政区域
            console.log(rs);
            var count = rs.boundaries.length; //行政区域的点有多少个
            if (count === 0) {
                alert('未能获取当前输入行政区域');
                return;
            }
            for (var i = 0; i < count; i++) {
                blist.push({ points: rs.boundaries[i], name: districtName });
            };
            //加载完成区域点后计数器-1
            districtLoading--;
            if (districtLoading == 0) {
                //全加载完成后画端点
                drawBoundary();
            }
        });
    }


    /**
     * 各种鼠标事件绑定
     */

    function drawBoundary() {
        //包含所有区域的点数组
        var pointArray = [];

        /*画遮蔽层的相关方法
        *思路: 首先在中国地图最外画一圈，圈住理论上所有的中国领土，然后再将每个闭合区域合并进来，并全部连到西北角。
        *      这样就做出了一个经过多次西北角的闭合多边形*/
        //定义中国东南西北端点，作为第一层
        var pNW = { lat: 59.0, lng: 73.0 }
        var pNE = { lat: 59.0, lng: 136.0 }
        var pSE = { lat: 3.0, lng: 136.0 }
        var pSW = { lat: 3.0, lng: 73.0 }
        //向数组中添加一次闭合多边形，并将西北角再加一次作为之后画闭合区域的起点
        var pArray = [];
        pArray.push(pNW);
        pArray.push(pSW);
        pArray.push(pSE);
        pArray.push(pNE);
        pArray.push(pNW);
        //循环添加各闭合区域
        for (var i = 0; i < blist.length; i++) {
            //添加显示用标签层
            var label = new BMap.Label(blist[i].name, { offset: new BMap.Size(20, -10) });
            label.hide();
            map.addOverlay(label);

            //添加多边形层并显示
            var ply = new BMap.Polygon(blist[i].points, { strokeWeight: 5, strokeColor: "#FF0000", fillOpacity: 0.01, fillColor: " #FFFFFF" }); //建立多边形覆盖物
            ply.name = blist[i].name;
            ply.label = label;
            map.addOverlay(ply);


            //将点增加到视野范围内
            var path = ply.getPath();
            pointArray = pointArray.concat(path);
            //将闭合区域加到遮蔽层上，每次添加完后要再加一次西北角作为下次添加的起点和最后一次的终点
            pArray = pArray.concat(path);
            pArray.push(pArray[0]);
        }

        //添加遮蔽层
        var plyall = new BMap.Polygon(pArray, { strokeOpacity: 0.0000001, strokeColor: "#000000", strokeWeight: 0.00001, fillColor: "#000000", fillOpacity: 0.4 }); //建立多边形覆盖物
        map.addOverlay(plyall);
    }

//////////////////////////////////////////


//////////////////////////////////////////




//setTimeout(function () {
//    getBoundary();
//}, 100);
    $(function () {
        getBoundary();
    });
    var points1=[{"lng":112.920,"lat":28.290,"count":100},{"lng":113.150,"lat":27.830,"count":90},
        {"lng":112.366,"lat":26.898,"count":50},{"lng":112.012,"lat":27.703,"count":89},{"lng":111.703,"lat":29.046,"count":100},
        {"lng":112.587,"lat":28.0308,"count":10},{"lng":113.140,"lat":29.384,"count":60},{"lng":112.971,"lat":27.823,"count":50},
        {"lng":111.483,"lat":27.253,"count":30},{"lng":110.471,"lat":29.136,"count":80},{"lng":109.993,"lat":27.582,"count":40},
        {"lng":113.058,"lat":25.877,"count":50},{"lng":111.619,"lat":26.427,"count":90},{"lng":109.719,"lat":28.311,"count":100}
    ]
    var points2=[{"lng":112.9717,"lat":28.0308,"count":100},{"lng":109.6581,"lat":28.9145,"count":100}];/////太多点

    //详细的参数,可以查看heatmap.js的文档 https://github.com/pa7/heatmap.js/blob/master/README.md
    //参数说明如下:
    /* visible 热力图是否显示,默认为true
     * opacity 热力的透明度,1-100
     * radius 势力图的每个点的半径大小
     * gradient  {JSON} 热力图的渐变区间 . gradient如下所示
     *	{
            .2:'rgb(0, 255, 255)',
            .5:'rgb(0, 110, 255)',
            .8:'rgb(100, 0, 255)'
        }
        其中 key 表示插值的位置, 0~1.
            value 为颜色值.
     */

    heatmapOverlay = new BMapLib.HeatmapOverlay({"radius":80});
    map.addOverlay(heatmapOverlay);
    var points=points1;
    heatmapOverlay.setDataSet({data:points1,max:100});
    map.addEventListener("zoomend", function(){
        if(this.getZoom()<8){
            heatmapOverlay.toggle();
            heatmapOverlay = new BMapLib.HeatmapOverlay({"radius":80});
            map.addOverlay(heatmapOverlay);
            var points=points1;
            heatmapOverlay.setDataSet({data:points1,max:100});
        }else{
            heatmapOverlay.toggle();
            heatmapOverlay = new BMapLib.HeatmapOverlay({"radius":20});
            map.addOverlay(heatmapOverlay);
            var points=points2;
            heatmapOverlay.setDataSet({data:points2,max:100});
        }

        console.log(points);
    });
    //是否显示热力图
    function setGradient(){
        /*格式如下所示:
       {
             0:'rgb(102, 255, 0)',
             .5:'rgb(255, 170, 0)',
             1:'rgb(255, 0, 0)'
       }*/
        var gradient = {};
        var colors = document.querySelectorAll("input[type='color']");
        colors = [].slice.call(colors,0);
        colors.forEach(function(ele){
            gradient[ele.getAttribute("data-key")] = ele.value;
        });
        heatmapOverlay.setOptions({"gradient":gradient});
    }
