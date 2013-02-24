# How to read

* md   markdown files
* html generate from source md  by pandoc

# code

```Java
public static void main(String [] args) {
	System.out.println("==========");
}
``` 

# pandoc
## 转html
```Bash
pandoc 01-chapter2.md -o chapter2.html -c Github.css
```
## 转word
```Bash
pandoc 01-chapter2.markdown -o chapter2.docx -c Github.css
```


