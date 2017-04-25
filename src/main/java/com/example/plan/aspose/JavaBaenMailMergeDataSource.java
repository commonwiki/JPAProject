package com.example.plan.aspose;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.aspose.words.IMailMergeDataSource;

/**
 * 实现对JavaBean的支持
 */
public class JavaBaenMailMergeDataSource<T> implements IMailMergeDataSource {

	private List<T> dataList = null;

	private String tableName;

	private int index;

	public JavaBaenMailMergeDataSource(List<T> dataList, String tableName) {
		this.dataList = dataList;
		this.tableName = tableName;
		index = -1;
	}

	public JavaBaenMailMergeDataSource(T bean, String tableName) {
		if (this.dataList == null) {
			this.dataList = new ArrayList<T>();
			dataList.add(bean);
		}
		this.tableName = tableName;
		index = -1;
	}

	/**
	 * 获取结果集总数
	 * 
	 * @return
	 */
	private int getCount() {
		return this.dataList.size();
	}

	public IMailMergeDataSource getChildDataSource(String arg0) throws Exception {
		return null;
	}

	public String getTableName() throws Exception {
		return this.tableName;
	}

	public boolean getValue(String key, Object[] args) throws Exception {

		if (index < 0 || index >= this.getCount()) {
			return false;
		}
		T bean = this.dataList.get(index);
		if (args != null && args.length > 0) {
			try {
				args[0] = BeanUtils.getProperty(bean, key);
			} catch (Exception e) {
				args[0] = key + ":匹配错误";
			}
			return true;
		}
		return false;
	}

	public boolean moveNext() throws Exception {
		index += 1;
		if (index >= this.getCount()) {
			return false;
		}
		return true;
	}

}
