package �Ž�ģʽ;

public class Client {

	public static void main(String[] args) {
		Wenjian wenjian;
		OS os;
		wenjian=(Wenjian) XMLUTILS.getBean("wenjian");
		os=(OS) XMLUTILS.getBean("os");
		
		os.setwenjian(wenjian);
		os.du("�ļ�");

	}

}
