package com.mccken201908.order.adapter;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxy;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.expr.SQLQueryExpr;
import com.alibaba.druid.sql.ast.statement.SQLJoinTableSource;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlSelectParser;
import com.alibaba.fastjson.JSON;

/**
 * @program: springcloudlearn
 * @description: 打印监控的sql
 * @author: mccken
 * @create: 2019-08-12 14:53
 **/
public class SqlFilterEventAdapter extends FilterEventAdapter {

	private static final Logger logger = LoggerFactory.getLogger(SqlFilterEventAdapter.class);

	//含有某字段的所有表
	private String[] tables = {"mccken_order", "B", "C"};

	@Override
	public PreparedStatementProxy connection_prepareStatement(FilterChain chain,
	                                                          ConnectionProxy connection, String sql) throws SQLException {

		//格式化输出
		String result = SQLUtils.formatMySql(sql);
		System.out.println("格式化后输出：\n" + result);

		//将string类型转换为sql对象
		SQLExpr exp = SQLUtils.toMySqlExpr(sql);

		logger.info(JSON.toJSONString(exp));

		//判断是否是查询sql
		if (exp instanceof SQLQueryExpr) {

			//将sql转换为select对象
			MySqlSelectQueryBlock select = (MySqlSelectQueryBlock) (((SQLQueryExpr) exp).getSubQuery()
					.getQuery());

			logger.info(JSON.toJSONString(select));

			//获取where对象
			SQLExpr where = select.getWhere();
			logger.info(JSON.toJSONString(where));
			//TODO 对where语句进行操作

			//获取所查询的表
			SQLTableSource from = select.getFrom();
			logger.info(JSON.toJSONString(from));

			//获取表别名
			String name = getName(from);
			//如果获取到name，说明查询到有某字段的表
			String appendJoinCondition = "";

			// 举个例子：对sql语句进行操作，加入一个关联查询（D加入表名，d别名 ，c字段 , f查询条件）
			appendJoinCondition = " join D d " + name
					+ ".c = d.c and d.c = f";

			//SQLTableSource oldFrom = select.getFrom();
			String s = SQLUtils.toMySqlString(from) + appendJoinCondition;
			SQLTableSource newTableSource = new MySqlSelectParser(s).parseTableSource();
			newTableSource.setParent(from.getParent());
			select.setFrom(newTableSource);
			logger.info(JSON.toJSONString(select));
		}
		return super.connection_prepareStatement(chain, connection, sql);
	}

	/**
	 * 递归查询含有某个字段的表名或别名
	 */
	private String getName(SQLTableSource fromInfo) {
		String name = "";
		List<String> tableList = Arrays.asList(tables);
		//判断是否是单表查询
		if (fromInfo.toString().split(",").length == 1 && fromInfo.toString().split(" ").length == 1) {
			//如果是单表查询，获取表别名
			name = fromInfo.getAlias();
			//别名为空则返回表名
			if (StringUtils.isBlank(name)) {
				name = fromInfo.toString();
			}
		} else {
			//判断是否有子查询
			if (fromInfo.toString().toLowerCase().contains("select")) {
				return name;
			}
			//如果是关联表查询，对象转换
			SQLJoinTableSource from = (SQLJoinTableSource) fromInfo;
			//获取左连接
			SQLTableSource left = from.getLeft();
			//获取右连接
			SQLTableSource right = from.getRight();
			//如果右连接表中有某字段则返回该表表名或别名，否则左连接部分继续递归查询
			//tableList：需要查询的表
			if (tableList.contains(right.toString())) {
				name = right.getAlias();
				if (StringUtils.isBlank(name)) {
					name = right.toString();
				}
			} else {
				//如果right中没有，则继续递归查询left
				name = getName(left);
			}
		}
		return name;
	}

}
