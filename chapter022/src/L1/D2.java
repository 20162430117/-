package L1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class D2 {
	private String weibo_Id;// ΢��ID��Weio��
	private String NickName;// �ǳ�
	private String Location;// ���ڵ�
	private String Sex;// �Ա�
	private String birthday;// ����
	private String company;// ��˾
	private String education;// ����
	private String tag;// ��ǩ
	private String fllows;// ��ע��
	private String fans;// ��˿����
	private String weibo_num;// ΢������
	private String RankNow;// ��ǰ�ȼ�
	private String exprience_value;// ����ֵ
	private String weibo_auth;// ΢���Ƿ���֤
	private static int rownum = 1;

	public static void main(String[] args) throws IOException {
		D2 ef1 = new D2();
		BufferedReader br = new BufferedReader(new FileReader("1.0.txt"));// ��ȡ΢��ϸ��Щ��1.0.txt
		FileOutputStream out = new FileOutputStream("2.0.xls");
		HSSFWorkbook wb = new HSSFWorkbook();// ����΢��excel����
		HSSFSheet sheet = wb.createSheet("΢����Ϣ��");
		HSSFRow row2 = sheet.createRow(0);
		row2.createCell(0).setCellValue("΢��ID");
		row2.createCell(1).setCellValue("�ǳ�");
		row2.createCell(2).setCellValue("���ڵ�");
		row2.createCell(3).setCellValue("�Ա�");
		row2.createCell(4).setCellValue("����");
		row2.createCell(5).setCellValue("��˾");
		row2.createCell(6).setCellValue("����");
		row2.createCell(7).setCellValue("��ǩ");
		row2.createCell(8).setCellValue("΢����֤(��/��)");
		row2.createCell(9).setCellValue("��ע��");
		row2.createCell(10).setCellValue("��˿��");
		row2.createCell(11).setCellValue("΢����");
		row2.createCell(12).setCellValue("��ǰ�ȼ�");
		row2.createCell(13).setCellValue("����ֵ");

		String NickNameeg="(�ǳƣ�)(\\S+)(\\s)";
		String WeiboNumeg = "([0-9]*)΢��";
		String eg3 = "�ȼ���Ϣ";
		String floowseg = "([0-9]*)��ע";
		String fanseg = "([0-9]*)��˿";
		String locationeg = "(���ڵأ�)(\\S+)(\\s)";
		String Sexeg = "(�Ա�)(\\S+)(\\s)";
		String birthdayeg = "(���գ�)(\\S+)(\\s)";
		String Ranknoweg = "(��ǰ�ȼ���)(\\S\\S\\S\\d+)";
		String valueseg = "([0-9]*)���������辭��ֵ";
		String eg13 = "΢����֤";
		String eg14="(����ֵ��)(\\d+)";
		String company1 = "������Ϣ[\t ]*��˾��[\t ]*([\u4E00-\u9FA50-9a-zA-Z��]*)[\t ]+[��ǩ��Ϣ]*";// ��˾
		String education = "������Ϣ[\t ]*([\u4E00-\u9FA5��\\(\\)\t 0-9]*)[\t ]*[��ǩ��Ϣ]?";// //����
		String label = "��ǩ��[\\t ]{0,}([\\u4E00-\\u9FA5\\t ]+)";
		String words = null;
		String[] arr = null;
		while ((words = br.readLine()) != null) {

			Pattern pattern = Pattern.compile(label);
			Matcher matcher = pattern.matcher(words);
			if (matcher.find()) {
				ef1.tag = matcher.group(1);
			} else
				ef1.tag = null;
			pattern = Pattern.compile(company1);
			matcher = pattern.matcher(words);
			if (matcher.find()) {
				ef1.company = matcher.group(1);
			} else
				ef1.company = null;

			pattern = Pattern.compile(education);
			matcher = pattern.matcher(words);
			if (matcher.find()) {
				ef1.education = matcher.group(1);
			} else
				ef1.education = null;
			
			
			pattern = Pattern.compile(NickNameeg);
			matcher = pattern.matcher(words);
			if (matcher.find()) {
				ef1.NickName = matcher.group(2);
			} else
				ef1.NickName = null;
			
			pattern = Pattern.compile(Ranknoweg);
			matcher = pattern.matcher(words);
			if (matcher.find()) {
				ef1.RankNow = matcher.group(2);
			} else
				ef1.RankNow = null;
			
			
			pattern = Pattern.compile(locationeg);
			matcher = pattern.matcher(words);
			if (matcher.find()) {
				ef1.Location = matcher.group(2);
			} else
				ef1.Location = null;
		
			pattern = Pattern.compile(Sexeg);
			matcher = pattern.matcher(words);
			if (matcher.find()) {
				ef1.Sex = matcher.group(2);
			} else
				ef1.Sex = null;
			//System.out.println(ef1.Sex);
			
			pattern = Pattern.compile(birthdayeg);
			matcher = pattern.matcher(words);
			if (matcher.find()) {
				ef1.birthday = matcher.group(2);
			} else
				ef1.birthday = null;
			arr = words.split("	+");
			ef1.weibo_Id = arr[0];
			for (int i = 0; i < arr.length; i++) {
				// ----------���˿��----------
				 pattern = Pattern.compile(fanseg);
				 matcher = pattern.matcher(arr[i]);
				if (matcher.find()) {
					ef1.fans = matcher.group(1);
				}
				// ------΢����ע��--------
				pattern = Pattern.compile(floowseg);
				matcher = pattern.matcher(arr[i]);
				if (matcher.find()) {
					ef1.fllows = matcher.group(1);
				}
				// ------΢������------
				pattern = Pattern.compile(WeiboNumeg);
				matcher = pattern.matcher(arr[i]);
				if (matcher.find()) {
					ef1.weibo_num = matcher.group(1);// ΢������
				}
				// ---------��ȡ΢����֤----------
				if (arr[i].contains(eg13))
					ef1.weibo_auth = "��";
				else
					ef1.weibo_auth = "��";

				// -----------��ȡ����ֵ--------
				if (arr[i].contains(eg3)) {
					String s1 = arr[i + 2];
					String[] arr1 = s1.split("��");
					String s2 = arr1[2];
					pattern = Pattern.compile(valueseg);
					matcher = pattern.matcher(s2);
					if (matcher.find()) {
						ef1.exprience_value = matcher.group(1);
					}
					else ef1.exprience_value=null;
				}

				// -------------------------------
			}
			HSSFRow row3 = sheet.createRow(rownum++);
			row3.createCell(0).setCellValue(ef1.weibo_Id);
			row3.createCell(1).setCellValue(ef1.NickName);
			row3.createCell(2).setCellValue(ef1.Location);
			row3.createCell(3).setCellValue(ef1.Sex);
			row3.createCell(4).setCellValue(ef1.birthday);
			row3.createCell(5).setCellValue(ef1.company);
			row3.createCell(6).setCellValue(ef1.education);
			row3.createCell(7).setCellValue(ef1.tag);
			row3.createCell(8).setCellValue(ef1.weibo_auth);
			row3.createCell(9).setCellValue(ef1.fllows);
			row3.createCell(10).setCellValue(ef1.fans);
			row3.createCell(11).setCellValue(ef1.weibo_num);
			row3.createCell(12).setCellValue(ef1.RankNow);
			row3.createCell(13).setCellValue(ef1.exprience_value);
		}
		try {
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		br.close();

	}
}