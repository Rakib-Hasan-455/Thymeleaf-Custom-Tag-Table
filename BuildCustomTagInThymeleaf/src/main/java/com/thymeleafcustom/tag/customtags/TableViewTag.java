package com.thymeleafcustom.tag.customtags;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import com.thymeleafcustom.tag.model.Employee;
import com.thymeleafcustom.tag.model.StakeholderGroup;

public class TableViewTag extends AbstractElementTagProcessor{

	public TableViewTag(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, "tableviewTag", true, null, false, 10);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		// TODO Auto-generated method stub
		String pageTitle = tag.getAttributeValue("pageTitle");
		String entityName = tag.getAttributeValue("entityName");

		String[] columnList = tag.getAttributeValue("columnNames").split(",");
		Set<String> columns = Arrays.stream(columnList)
                .map(String::trim) // Optional: Trim each element to remove whitespace
                .collect(Collectors.toSet());
	
		String content = "<h1>"+pageTitle+"</h1>";
		content += "<h3> Entity name is -> "+entityName+"</h3><br>";
		if(entityName.equals("employee")) {
			content = getEmployeeContent(content, columns);
		} else if(entityName.equals("stakeholderGroup")) {
			content = getStakeholderGroupContent(content, columns);
		} else if(entityName.equals("dynamicStakeholderGroup")) {
			content = dynamicStakeHolderGroupContent(content, columns);
		}
			
		structureHandler.replaceWith(content, false);
	}
	
	private String getEmployeeContent(String content, Set<String> columns) {
		System.out.print("hi");
		content += "<table border='1'>";
		if (columns != null) {
			content += "<tr>";
		    for (String colName : columns) {
		        content += "<th>" + colName + "</th>";
		    }
		    content += "</tr>";
		}
		Set<Employee> empList = getEmpData();
		if(empList != null) {
			for(Employee emp: empList) {

				content += "<tr>";
				if(columns.contains("name")) {
					content += "<td>"+emp.getName()+"</td>";
				}
				if(columns.contains("age")) {
					content += "<td>"+emp.getAge()+"</td>";
				}
				if(columns.contains("contactNumber")) {
					content += "<td>"+emp.getContactNumber()+"</td>";
				}
				if(columns.contains("email")) {
					content += "<td>"+emp.getEmail()+"</td>";
				}
				content += "</tr>";
			}
		}

		content += "</table>";
		return content;
	}
	
	private Set<Employee> getEmpData() {
		Set<Employee> empList = new HashSet<>();
		empList.add(new Employee("Rakib", "rakib@gmail.com", 55, "01928743896"));
		empList.add(new Employee("Sabbi", "sabbi@gmail.com", 25, "01928723233"));
		empList.add(new Employee("bulbul", "bulbul@gmail.com", 22, "01928722321"));		
		return empList;
	}
	
	private String getStakeholderGroupContent(String content, Set<String> columns) {
		System.out.print("hi");
		content += "<table border='1'>";
		if (columns != null) {
			content += "<tr>";
		    for (String colName : columns) {
		        content += "<th>" + colName + "</th>";
		    }
		    content += "</tr>";
		}
		Set<StakeholderGroup> stkList = getStkGrpData();
		if(stkList != null) {
			for(StakeholderGroup stkGroup: stkList) {
				content += "<tr>";
				if(columns.contains("groupName")) {
					content += "<td>"+stkGroup.getGroupName()+"</td>";
				}
				if(columns.contains("groupOwner")) {
					content += "<td>"+stkGroup.getGroupOwner()+"</td>";
				}
				if(columns.contains("stakeholders")) {
					// loop
					content += "<td>";
					for(Employee stakeholder: stkGroup.getStakeholders()) {
						content += stakeholder.getName() + "<br>";
					}
					content += "</td>";
				}
				if(columns.contains("children")) {
					// loop
					//content += "<td>"+stkGroup.getEmail()+"</td>";
				}
				content += "</tr>";
			}
		}

		content += "</table>";
		return content;
	}
	

	
	private Set<StakeholderGroup> getStkGrpData() {
		Set<StakeholderGroup> stkList = new HashSet<>();
		stkList.add(new StakeholderGroup("StkGrp1", "Shahriar", getEmpData(),  null));
		Set<StakeholderGroup> stkGrp1ChildList = new HashSet<>();
		stkGrp1ChildList.add(new StakeholderGroup("StkGrp1Child1", "Shahriar1", getEmpData(),  null));
		stkGrp1ChildList.add(new StakeholderGroup("StkGrp1Child2", "Shahriar2", getEmpData(),  null));
		stkList.add(new StakeholderGroup("StkGrp2", "Rakib", getEmpData(),  stkGrp1ChildList));
		stkList.add(new StakeholderGroup("StkGrp3", "Mayen", getEmpData(),  null));		
		return stkList;
	}
	
	
	private StakeholderGroup getStkGrpData2() {

		Set<StakeholderGroup> stkGrp23ChildList1 = new HashSet<>();
		stkGrp23ChildList1.add(new StakeholderGroup("StkGrp23Child1", "Shahriar1", getEmpData(),  null));
		stkGrp23ChildList1.add(new StakeholderGroup("StkGrp23Child2", "Shahriar2", getEmpData(),  null));
		
		Set<StakeholderGroup> stkGrp2ChildList = new HashSet<>();
		stkGrp2ChildList.add(new StakeholderGroup("StkGrp23Child1", "Shahriar1", getEmpData(),  stkGrp23ChildList1));
		stkGrp2ChildList.add(new StakeholderGroup("StkGrp23Child2", "Shahriar2", getEmpData(),  null));
		

		Set<StakeholderGroup> stkGrp3ChildList = new HashSet<>();
		stkGrp3ChildList.add(new StakeholderGroup("StkGrp3Child1", "Shahriar1", getEmpData(),  null));
		stkGrp3ChildList.add(new StakeholderGroup("StkGrp3Child2", "Shahriar2", getEmpData(),  null));
		
		Set<StakeholderGroup> stkList = new HashSet<>();
		stkList.add(new StakeholderGroup("StkGrp2", "Rakib", getEmpData(),  stkGrp2ChildList));
		stkList.add(new StakeholderGroup("StkGrp3", "Mayen", getEmpData(),  stkGrp3ChildList));
		
		StakeholderGroup stakeholder = new StakeholderGroup("StkGrp1", "Shahriar1", getEmpData(),  stkList);
		return stakeholder;
	}
	
	private String dynamicStakeHolderGroupContent(String content, Set<String> columns) {
	    // table depth
	    StakeholderGroup rootGroup = getStkGrpData2();
	    int subGroupDepth = getDepth(rootGroup);

	    StringBuilder sb = new StringBuilder();
	    sb.append(content);
	    sb.append(subGroupDepth).append("<br/>");
	    sb.append("<table border='1'>");
	    if (columns != null) {
	        sb.append("<tr>");
	        sb.append("<th> Stk Group 1 </th>");
	        for (int i = 0; i < subGroupDepth; i++) {
	            sb.append("<th> Sub Group </th>");
	        }
	        sb.append("<th> Stakeholder </th>");
	        sb.append("<th> Requirement </th>");
	        sb.append("<th> Objective </th>");
	        sb.append("</tr>");
	    }
	    buildFunctionTabularsheet(rootGroup, sb,0, subGroupDepth);
	    sb.append("</table>");
	    return sb.toString();
	}
	
	private void buildFunctionTabularsheet(StakeholderGroup function, StringBuilder content,int columnCount, int depth) {
		
		 Set<StakeholderGroup> functions = function.getChildren()!=null ? function.getChildren() : new HashSet<>();
	    content.append("<tr>");
	    for(int i=0;i<columnCount;i++) {
	    	content.append("<td></td>");
	    }

	    content.append("<td>").append(function.getGroupName()).append("</td>");
	    
	    for (int i = 0; i < depth-columnCount; i++) {
	        content.append("<td></td>");
	    }
	    columnCount++;
	    content.append("<td>stakeholder 1</td>");
	    content.append("</tr>");
	    
	    
	    if (functions != null) {
	        for (StakeholderGroup func : functions) {
	            buildFunctionTabularsheet(func,  content,columnCount, depth);
	        }
	    }
	}
	
	public int getDepth(StakeholderGroup f) {
		if (f.getChildren() == null || f.getChildren().size() == 0
				|| (f.getChildren().size() == 1 && f.getChildren().iterator().next() == f)) {
			return 0;
		}
		int depth = 0;
		for (StakeholderGroup subFunction : f.getChildren()) {
			if (isRootOfRoot(subFunction, f)) {
				continue;
			}
			depth = Math.max(depth, getDepth(subFunction) + 1);
		}
		return depth;
	}

	private static boolean isRootOfRoot(StakeholderGroup child, StakeholderGroup root) {
		if (child == root || child.equals(root)) {
			return true;
		} else {
			return false;
		}

	}

	private int totalSize = 0;
	public int getMaximumChildrenSize(StakeholderGroup f, int maxSize) {

		int functionSize = f.getChildren().size();

		int hasProcedure = 0;
		if (!f.getStakeholders().isEmpty()) {
			hasProcedure = 1;
		}
		if (hasProcedure == 1 || functionSize > 0) {
			totalSize = totalSize - maxSize;
		}

		maxSize = functionSize + hasProcedure;

		totalSize = totalSize + maxSize;

		for (StakeholderGroup subFunction : f.getChildren()) {
			if (isRootOfRoot(subFunction, f)) {
				continue;
			}
			maxSize = getMaximumChildrenSize(subFunction, 1);
		}

		return totalSize;
	}
}
