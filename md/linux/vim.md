## 常用快捷方式
* **注释多行 ctrl + v  ，选中行  ,shift + i ，搞入#或//  ，按esc**
* 蜸去掉注释  ctrl + v ,选中区域，d
* dd 删除一行
* yy 复制一行
* dw 删除一个单词
* x 剪切
* w  b  向前和后路过一个单词
* : set nonumber (nonu) 不显示行号
* gg 将光标移到文件第一行第一列
* G 表示将光标移到文件末尾
* 从一个括号快速跳转到另外一个括号你可以在一个括号上按”%,光标放在一个{}上,按'%',找到相对应的另一个{},
* o在光标下方新开一行并将光标置于新行行首，进入插入模式。
* O同上，在光标上方。
* vim -d file1 file2 直接打开两个文件对比
* /abc  按n，N 查找下一个，上一个
* 显示行号 set nu  跳转 n G  如 2 G，表示跳转到第二行 ，也可:行号
* /pattern         从光标开始处向文件尾搜索pattern
* ?pattern         从光标开始处向文件首搜索pattern
* 对齐 选中，按=
* fa → 到下一个为a的字符处，你也可以fs到下一个为s的字符
* :%s/four/4/g  %表整文 g表行
* 按!号可输入linux命令
* 另存为 :w 文件名
* 全选 ggVG 

    gg 让光标移到首行，在vim才有效，vi中无效 
    V   是进入Visual(可视）模式 
    G  光标移到最后一行   

## vim中文乱码问题
```Bash
$vim ~/.vimrc

let &termencoding=&encoding
set fileencodings=utf-8,gbk

$:wq
```
## 选择技巧

* vi{ 选中{}中间的内容,不包括{}
* va{ 选中{}中间内容，包括{}
* vi( 选中()中间内容
* vi< 选中<>中间内容
* vi[ 选中[]中间内容
* vit 选中中间的内容
* vi” 选中”"中间内容
* vi’ 选中”中间的内容
* vis 选中一个句子
* vib 选中一个block
* viw选中一个单词
* vip 选中一个段落

## vim-fold
* 选中，zf,创建折叠 zf %
* zo 打开
* zc 关闭
* zR 打开所有折叠
* zM 关闭所有折叠
* makeview 保存
* loadview 载入view


## NERDTree
### 快捷键
* ctrl + w + 方向键 ： 切换窗口
* o 在已有窗口中打开文件、目录或书签，并跳到该窗口 
* O 递归打开
* x 合拢目录
* X 合拢递归
* C 将选中目录或选中文件的父目录设为根结点
* r 刷新
* R 递归刷新
* ! 执行当前文件
* m 结点编辑
* i 分窗口打开

## snipmake
* 触发词位置  ~/.vim/snippet/java.snippets
