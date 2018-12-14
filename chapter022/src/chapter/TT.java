package chapter;

import java.util.ArrayList;

abstract class Unit {
	public abstract void handleArchives();
}

class Office extends Unit {
	private String name;

	public Office(String name) {
		this.name = name;
	}

	public void handleArchives() {
		System.out.println(this.name + "处理公文");
	}
}

class Insituation extends Unit {
	private ArrayList list = new ArrayList();
	private String name;

	public Insituation(String name) {
		this.name = name;
	}

	public void add(Unit Unit) {
		list.add(Unit);

	}

	public void handleArchives() {
		System.out.println(this.name + "接受并下发公文");
		for (Object obj : list) {
			((Unit) obj).handleArchives();

		}
	}
}

class Client {
	public static void main(String[] args) {
		Insituation Bjzongbu, Hnsubschool, Cspost, Xtpost;
		Unit tOffice1, tOffice2, tOffice3, tOffice4, aOffice1, aOffice2, aOffice3, aOffice4;
		Hnsubschool = new Insituation("湖南分校");
		Bjzongbu = new Insituation("北京总部");
		Cspost = new Insituation("长沙教学点");
		Xtpost = new Insituation("湘潭教学点");
		tOffice1 = new Office("北京教务办公室");
		tOffice2 = new Office("湖南教务办公室");
		tOffice3 = new Office("长沙教务办公室");
		tOffice4 = new Office("湘潭教务办公室");
		aOffice1 = new Office("北京行政办公室");
		aOffice2 = new Office("湖南行政办公室");
		aOffice3 = new Office("长沙行政办公室");
		aOffice4 = new Office("湘潭行政办公室");
		Cspost.add(aOffice3);
		Cspost.add(tOffice3);
		Xtpost.add(tOffice4);
		Xtpost.add(aOffice4);
		Hnsubschool.add(Cspost);
		Hnsubschool.add(Xtpost);
		Hnsubschool.add(aOffice2);
		Hnsubschool.add(tOffice2);

		Bjzongbu.add(Hnsubschool);
		Bjzongbu.add(aOffice1);
		Bjzongbu.add(tOffice1);
		Bjzongbu.handleArchives();

	}
}
