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
	private String weibo_Id;// 微博ID和Weio大咖
	private String NickName;// 昵称
	private String Location;// 所在地
	private String Sex;// 性别
	private String birthday;// 生日
	private String company;// 公司
	private String education;// 教育
	private String tag;// 标签
	private String fllows;// 关注数
	private String fans;// 粉丝数量
	private String weibo_num;// 微博数量
	private String RankNow;// 当前等级
	private String exprience_value;// 经验值
	private String weibo_auth;// 微博是否认证
	private static int rownum = 1;

	public static void main(String[] args) throws IOException {
		D2 ef1 = new D2();
		BufferedReader br = new BufferedReader(new FileReader("1.0.txt"));// 读取微博细腻些表1.0.txt
		FileOutputStream out = new FileOutputStream("2.0.xls");
		HSSFWorkbook wb = new HSSFWorkbook();// 创建微博excel对象
		HSSFSheet sheet = wb.createSheet("微博信息表");
		HSSFRow row2 = sheet.createRow(0);
		row2.createCell(0).setCellValue("微博ID");
		row2.createCell(1).setCellValue("昵称");
		row2.createCell(2).setCellValue("所在地");
		row2.createCell(3).setCellValue("性别");
		row2.createCell(4).setCellValue("生日");
		row2.createCell(5).setCellValue("公司");
		row2.createCell(6).setCellValue("教育");
		row2.createCell(7).setCellValue("标签");
		row2.createCell(8).setCellValue("微博认证(是/否)");
		row2.createCell(9).setCellValue("关注数");
		row2.createCell(10).setCellValue("粉丝数");
		row2.createCell(11).setCellValue("微博数");
		row2.createCell(12).setCellValue("当前等级");
		row2.createCell(13).setCellValue("经验值");

		String NickNameeg="(昵称：)(\\S+)(\\s)";
		String WeiboNumeg = "([0-9]*)微博";
		String eg3 = "等级信息";
		String floowseg = "([0-9]*)关注";
		String fanseg = "([0-9]*)粉丝";
		String locationeg = "(所在地：)(\\S+)(\\s)";
		String Sexeg = "(性别：)(\\S+)(\\s)";
		String birthdayeg = "(生日：)(\\S+)(\\s)";
		String Ranknoweg = "(当前等级：)(\\S\\S\\S\\d+)";
		String valueseg = "([0-9]*)距离升级需经验值";
		String eg13 = "微博认证";
		String eg14="(经验值：)(\\d+)";
		String company1 = "工作信息[\t ]*公司：[\t ]*([\u4E00-\u9FA50-9a-zA-Z：]*)[\t ]+[标签信息]*";// 公司
		String education = "教育信息[\t ]*([\u4E00-\u9FA5：\\(\\)\t 0-9]*)[\t ]*[标签信息]?";// //教育
		String label = "标签：[\\t ]{0,}([\\u4E00-\\u9FA5\\t ]+)";
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
				// ----------获粉丝数----------
				 pattern = Pattern.compile(fanseg);
				 matcher = pattern.matcher(arr[i]);
				if (matcher.find()) {
					ef1.fans = matcher.group(1);
				}
				// ------微博关注数--------
				pattern = Pattern.compile(floowseg);
				matcher = pattern.matcher(arr[i]);
				if (matcher.find()) {
					ef1.fllows = matcher.group(1);
				}
				// ------微博数量------
				pattern = Pattern.compile(WeiboNumeg);
				matcher = pattern.matcher(arr[i]);
				if (matcher.find()) {
					ef1.weibo_num = matcher.group(1);// 微博数量
				}
				// ---------获取微博认证----------
				if (arr[i].contains(eg13))
					ef1.weibo_auth = "是";
				else
					ef1.weibo_auth = "否";

				// -----------获取经验值--------
				if (arr[i].contains(eg3)) {
					String s1 = arr[i + 2];
					String[] arr1 = s1.split("：");
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