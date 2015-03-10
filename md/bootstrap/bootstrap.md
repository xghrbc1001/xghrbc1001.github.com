# 布局
## 嵌套布局，分12个网格
```
<div class="container">
	<div class="row">
		<div class="span6"><p>abcd</p></div>
		<div class="span6"><p>cde<p></div>
	</div>
</div>
```
## 流动布局，按百分比,span2表示20%，嵌套使用时注意
```
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span6"><p>abcd</p></div>
		<div class="span6"><p>cde<p></div>
	</div>
</div>
```

## 响应布局，如手机
```
<style>
body {background-color:#000000;}
// 当窗口小于767像素
@media (max-width:767px) {body {background-color:#ff6699;}}
@media (min-width:767px) {body {background-color:#ff6699;}}
@media (min-width:767px) and (max-width:900px) {body {background-color:#ff6699;}}
</style>

// 将普通布局改为响应布局
加入bootstrap-responsive.css

// 常用类
.visible-phone 在phone上显示，在其它上隐藏，即用了display属性
.visible-tablet 在平板上显示，其它上不显示
.visible-desktop
.hidden-phone
.hidden-tablet
.hidden-desktop
```
