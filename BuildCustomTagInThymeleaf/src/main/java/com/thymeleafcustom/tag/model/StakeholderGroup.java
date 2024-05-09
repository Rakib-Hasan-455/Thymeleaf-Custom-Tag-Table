package com.thymeleafcustom.tag.model;

import java.util.HashSet;
import java.util.Set;


public class StakeholderGroup {
	private String groupName;
	private String groupOwner;
	private Set<Employee> stakeholders;
	
	private Set<StakeholderGroup> children = new HashSet<>();

	public StakeholderGroup(String groupName, String groupOwner, Set<Employee> stakeholders,
			Set<StakeholderGroup> children) {
		super();
		this.groupName = groupName;
		this.groupOwner = groupOwner;
		this.stakeholders = stakeholders;
		this.children = children;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupOwner() {
		return groupOwner;
	}

	public void setGroupOwner(String groupOwner) {
		this.groupOwner = groupOwner;
	}

	public Set<Employee> getStakeholders() {
		return stakeholders;
	}

	public void setStakeholders(Set<Employee> stakeholders) {
		this.stakeholders = stakeholders;
	}

	public Set<StakeholderGroup> getChildren() {
		return children;
	}

	public void setChildren(Set<StakeholderGroup> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "StakeholderGroup [groupName=" + groupName + ", groupOwner=" + groupOwner + ", stakeholders="
				+ stakeholders + ", children=" + children + "]";
	}
	
	
}
