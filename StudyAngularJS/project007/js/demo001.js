/**
 * Created by jack on 16/7/29.
 */
// document.write("<script language='javascript' src='demo002.js'></script>");
var oHead = document.getElementsByTagName('HEAD').item(0);
var oScript= document.createElement("script");
oScript.type = "text/javascript";
oScript.src="demo002.js";
oHead.appendChild( oScript);

console.log("demo001");
say();