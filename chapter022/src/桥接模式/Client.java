package 桥接模式;

public class Client {

	public static void main(String[] args) {
		Wenjian wenjian;
		OS os;
		wenjian=(Wenjian) XMLUTILS.getBean("wenjian");
		os=(OS) XMLUTILS.getBean("os");
		
		os.setwenjian(wenjian);
		os.du("文件");

	}

}
