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
		System.out.println(this.name + "������");
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
		System.out.println(this.name + "���ܲ��·�����");
		for (Object obj : list) {
			((Unit) obj).handleArchives();

		}
	}
}

class Client {
	public static void main(String[] args) {
		Insituation Bjzongbu, Hnsubschool, Cspost, Xtpost;
		Unit tOffice1, tOffice2, tOffice3, tOffice4, aOffice1, aOffice2, aOffice3, aOffice4;
		Hnsubschool = new Insituation("���Ϸ�У");
		Bjzongbu = new Insituation("�����ܲ�");
		Cspost = new Insituation("��ɳ��ѧ��");
		Xtpost = new Insituation("��̶��ѧ��");
		tOffice1 = new Office("��������칫��");
		tOffice2 = new Office("���Ͻ���칫��");
		tOffice3 = new Office("��ɳ����칫��");
		tOffice4 = new Office("��̶����칫��");
		aOffice1 = new Office("���������칫��");
		aOffice2 = new Office("���������칫��");
		aOffice3 = new Office("��ɳ�����칫��");
		aOffice4 = new Office("��̶�����칫��");
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
