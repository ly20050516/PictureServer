package com.ly.car;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private List<CarItem> list = new ArrayList<CarItem>();

	public List<CarItem> list() {
		return list;
	}

	public void add(CarItem carItem) {
		this.list.add(carItem);
	}

	public void remove(String id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				list.remove(i);
				break;
			}
		}
	}
}
