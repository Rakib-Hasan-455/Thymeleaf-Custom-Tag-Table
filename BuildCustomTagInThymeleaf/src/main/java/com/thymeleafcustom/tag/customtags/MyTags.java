package com.thymeleafcustom.tag.customtags;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;

@Component
public class MyTags extends AbstractProcessorDialect {

	protected MyTags() {
		super("My Tags", "mytags", 10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		// TODO Auto-generated method stub
		Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new TableViewTag(getPrefix()));
		return processors;
	}

}
