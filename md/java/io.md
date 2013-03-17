## 流的概念

* 输入流和输出流，是相对于内存来说的

## 随机存取文件 RandomAccessFile
```Java
File file;
RandomAccessFile ref = new RandomAccessFile(file,"rw"); // rw表示打开文件的方式
while(ref.getFilePointer() < ref.length()) {
	String name=ref.readUTF();
	if("javamm".equals(name)) {
		ref.writeInt(10);
		break;
	} else {
		ref.skipBytes(4); //int为4个字节，平台无关
	}
}
	ref.writeUTF("javamm");
	ref.writeInt(0);
	ref.close();
```
## nio(new io)
* 采用块的方式，整块的从数据中读取和写块
* buffer 
* channel通道，双向，直接和os相关联 
* charset字符集转换


