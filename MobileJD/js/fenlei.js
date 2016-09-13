/**
 * Created by jack on 16/9/13.
 */
$(document).ready(function () {
    // 设置分类的监听
    $(".clzName ul li").click(function () {
        // 获取当前被点击的元素的ID
        var id = $(this).attr("id");
        console.log("当前点击的分类ID" + id);
        reqeustFlDetail(id);

    });
});

/**
 * 请求分类的详情
 */
function reqeustFlDetail(id) {
    // 根据点击的分类ID获取对应的分类详情,之后改变元素
    // 没有数据请求,模拟一下得了
    var gp = $(".hotGood li a p");
    if (id == "hotfl") {
        setPDetail("热门推荐");
        return;
    }
    if (id == "womenfl") {
        setPDetail("潮流女装");
        return;
    }
    if (id == "girlfl") {
        setPDetail("品牌女装");
        return;
    }
    if (id == "hzfl") {
        setPDetail("各户化妆");
        return;
    }
    if (id == "dqfl") {
        setPDetail("家用电器");
        return;
    }
    if (id == "pcfl") {
        setPDetail("电脑办公");
        return;
    }
    if (id == "myfl") {
        setPDetail("母婴童装");
        return;
    }
    if (id == "bkfl") {
        setPDetail("图书");
        return;
    }
    if (id == "dnfl") {
        setPDetail("食材");
        return;
    }
    if (id == "nifl") {
        setPDetail("酒水饮料");
        return;
    }
    if (id == "defl") {
        setPDetail("开发丛书");
        return;
    }


    if (id == "macfl") {
        setPDetail("Mac序列");
        return;
    }
    if (id == "flfl") {
        setPDetail("各种分类");
        return;
    }
    if (id == "youfl") {
        setPDetail("看你的");
        return;
    }
    if (id == "knfl") {
        setPDetail("我也不知道了");
        return;
    }
    if (id == "nkfl") {
        setPDetail("你看着办");
        return;
    }

}

var imgtype=0;
/**
 * 设置内容
 * @param tx
 */
function setPDetail(tx) {
    var gp = $(".hotGood li a p");
    gp.text("");
    gp.text(tx);
}