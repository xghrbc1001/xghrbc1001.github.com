## ���ÿ�ݷ�ʽ
* **ע�Ͷ��� ctrl + v  ��ѡ����  ,shift + i ������#��//  ����esc**
* �Sȥ��ע��  ctrl + v ,ѡ������d
* dd ɾ��һ��
* yy ����һ��
* dw ɾ��һ������
* x ����
* w  b  ��ǰ�ͺ�·��һ������
* : set nonumber (nonu) ����ʾ�к�
* gg ������Ƶ��ļ���һ�е�һ��
* G ��ʾ������Ƶ��ļ�ĩβ
* ��һ�����ſ�����ת������һ�������������һ�������ϰ���%,������һ��{}��,��'%',�ҵ����Ӧ����һ��{},
* o�ڹ���·��¿�һ�в�����������������ף��������ģʽ��
* Oͬ�ϣ��ڹ���Ϸ���
* vim -d file1 file2 ֱ�Ӵ������ļ��Ա�
* /abc  ��n��N ������һ������һ��
* ��ʾ�к� set nu  ��ת n G  �� 2 G����ʾ��ת���ڶ��� ��Ҳ��:�к�
* /pattern         �ӹ�꿪ʼ�����ļ�β����pattern
* ?pattern         �ӹ�꿪ʼ�����ļ�������pattern
* ���� ѡ�У���=
* fa �� ����һ��Ϊa���ַ�������Ҳ����fs����һ��Ϊs���ַ�
* :%s/four/4/g  %������ g����
* ��!�ſ�����linux����
* ���Ϊ :w �ļ���
* w �� ����һ�����ʵĿ�ͷ b
* e �� ����һ�����ʵĽ�β
* * �� #:  ƥ���굱ǰ���ڵĵ��ʣ��ƶ���굽��һ��������һ����ƥ�䵥�ʣ�*����һ����#����һ����
* ȫѡ ggVG 
* gD �����ֲ��������崦
* n> n�е�����
* n< n����ǰ����
* >> �� << ���һ���������

    gg �ù���Ƶ����У���vim����Ч��vi����Ч 
    V   �ǽ���Visual(���ӣ�ģʽ 
    G  ����Ƶ����һ��   

## vim������������
```Bash
$vim ~/.vimrc

let &termencoding=&encoding
set fileencodings=utf-8,gbk

$:wq
```
## ѡ����

* vi{ ѡ��{}�м������,������{}
* va{ ѡ��{}�м����ݣ�����{}
* vi( ѡ��()�м�����
* vi< ѡ��<>�м�����
* vi[ ѡ��[]�м�����
* vit ѡ���м������
* vi�� ѡ�С�"�м�����
* vi�� ѡ�С��м������
* vis ѡ��һ������
* vib ѡ��һ��block
* viwѡ��һ������
* vip ѡ��һ������

## vim-fold
* ѡ�У�zf,�����۵� zf %
* zo ��
* zc �ر�
* zR �������۵�
* zM �ر������۵�
* makeview ����
* loadview ����view


## NERDTree �ر�
### ��ݼ�
* ctrl + w + ����� �� �л�����
* o �����д����д��ļ���Ŀ¼����ǩ���������ô��� 
* O �ݹ��
* x ��£Ŀ¼
* X ��£�ݹ�
* C ��ѡ��Ŀ¼��ѡ���ļ��ĸ�Ŀ¼��Ϊ�����
* r ˢ��
* R �ݹ�ˢ��
* ! ִ�е�ǰ�ļ�
* m ���༭
* i �ִ��ڴ�
* s ��ֱ�ִ���
* p �����ڵ�
* P �����ڵ�

## snipmake �ر�
* ������λ��  ~/.vim/snippet/java.snippets

## ctags
### ��ַ

http://ctags.sourceforge.net

### ����

```Bash
# ����

ctags -R -o ~/.vim/ctags/pythontags /somepythondir/

# ����ctags·�� 

set tags=/home/xxx/xx/tags, xxxx/tags,......

```

## taglist

https://github.com/vim-scripts/taglist.vim

�൱��outline,��Ҫctags֧��

## pathogen

https://github.com/tpope/vim-pathogen

�������

### ��װ

* ��.vim�ļ����½���autoload��bundleĿ¼
* �����ص�ַ��ȡpathogen.vim�ļ������临�Ƶ�autoloadĿ¼��
* ��.vimrc�ļ����������´��룺 call pathogen#infect()

### encoding

��Vim�п���ֱ�Ӳ鿴�ļ����� :set fileencoding ������ʾ�ļ������ʽ�� �����ֻ����鿴���������ʽ���ļ�����������Vim�鿴�ļ���������⣬��ô������� ~/.vimrc �ļ�������������ݣ� set encoding=utf-8 fileencodings=ucs-bom,utf-8,cp936 �������Ϳ�����vim�Զ�ʶ���ļ����루�����Զ�ʶ��UTF-8����GBK������ļ�������ʵ��������fileencodings�ṩ�ı����б��ԣ��� ��û���ҵ����ʵı��룬����latin-1(ASCII)����򿪡�

### vim & find
vim `find -name test`

### ����
�ڵ���ʱ��*��

### gg���ѹر궨λ�������棩��V������VISUALģʽ����shift+g��ѡ����ƪ�ı�����Ȼ��

### vim ����
```
let &termencoding=&encoding
set fileencodings=utf-8,gbk

```
