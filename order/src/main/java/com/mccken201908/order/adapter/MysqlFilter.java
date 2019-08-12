package com.mccken201908.order.adapter;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.CallableStatementProxy;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxy;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLInSubQueryExpr;
import com.alibaba.druid.sql.ast.expr.SQLQueryExpr;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.ast.statement.SQLSubqueryTableSource;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlDeleteStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlUpdateStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springcloudlearn
 * @description: 打印监控的sql
 * @author: mccken
 * @create: 2019-08-12 14:53
 **/
//public class SqlFilterEventAdapter extends FilterEventAdapter {
public class MysqlFilter extends FilterEventAdapter{

	private static final Logger LOG = LoggerFactory.getLogger(MysqlFilter.class);
//
//	private static final String BLANK_STRING = " ";
//
//	private static final String SQL_FIELD_WHERE = "WHERE";
//
//	private static final String TABLE_FIELD_TENANT_ID = "tenant_id";
//
//	private static final String SQL_FIELD_AND = " AND ";
//
//	private static final String SQL_FIELD_EQUAL = " = ";
//
//	@Override
//	public CallableStatementProxy connection_prepareCall(FilterChain chain, ConnectionProxy connection, String sql)
//			throws SQLException {
//		// TODO Auto-generated method stub
//		return super.connection_prepareCall(chain, connection, sql);
//	}
//
//	@Override
//	public PreparedStatementProxy connection_prepareStatement(FilterChain chain, ConnectionProxy connection, String sql)
//			throws SQLException {
//		LOG.info("orginal sql = {}", sql);
//		try {
//			MySqlStatementParser parser = new MySqlStatementParser(sql);
//			SQLStatement stmt = parser.parseStatement();
//			if (stmt instanceof SQLSelectStatement) {
//				sql = doSelectSql(sql);
//			} else if (stmt instanceof MySqlUpdateStatement) {
//				MySqlUpdateStatement update = (MySqlUpdateStatement)stmt;
//				sql = doUpdateSql(sql, update);
//			} else if (stmt instanceof MySqlDeleteStatement) {
//				MySqlDeleteStatement delete = (MySqlDeleteStatement)stmt;
//				sql = doDeleteSql(sql, delete);
//			}
//		} catch (Exception e) {
//			LOG.error("delete self filter sql error {}", e.getMessage());
//		}
//		LOG.info("new sql = {}", sql);
//		return super.connection_prepareStatement(chain, connection, sql);
//	}
//
//	/**
//	 * 处理delete语句
//	 *
//	 * @param sql
//	 *     sql语句
//	 * @param stmt
//	 *     解析的语句
//	 * @return 修改的后的sql
//	 */
//	private String doDeleteSql(String sql, SQLStatement stmt) {
//		MySqlDeleteStatement delete = (MySqlDeleteStatement)stmt;
//		SQLExpr where = delete.getWhere();
//		StringBuffer buffer = new StringBuffer();
//		// 如果包括where条件 则取where之前sql字符串
//		if (where != null) {
//			int index = sql.toUpperCase().indexOf(SQL_FIELD_WHERE);
//			buffer.append(sql.substring(0, index));
//		} else {
//			// 取全部sql
//			buffer.append(sql);
//		}
//		// 拼接where条件
//		buffer.append(BLANK_STRING).append(appendWhere(where));
//		return buffer.toString();
//	}
//
//	/**
//	 * 处理更新语句
//	 *
//	 * @param sql
//	 *     sql语句
//	 * @param stmt
//	 *     解析的语句
//	 * @return 修改的后的sql
//	 */
//	private String doUpdateSql(String sql, SQLStatement stmt) {
//		MySqlUpdateStatement update = (MySqlUpdateStatement)stmt;
//		SQLExpr where = update.getWhere();
//		StringBuffer buffer = new StringBuffer();
//		// 如果包括where条件 则去where之前sql字符串
//		if (where != null) {
//			int index = sql.toUpperCase().indexOf(SQL_FIELD_WHERE);
//			buffer.append(sql.substring(0, index));
//		} else {
//			// 取全部sql
//			buffer.append(sql);
//		}
//		// 拼接where条件
//		buffer.append(BLANK_STRING).append(appendWhere(where));
//		return buffer.toString();
//	}
//
//	private String doSelectSql(String sql) {
//		// 将string类型转换为sql对象
//		SQLExpr exp = SQLUtils.toMySqlExpr(sql);
//		// 判断是否是查询sql
//		if (exp instanceof SQLQueryExpr) {
//			// 将sql转换为select对象
//			MySqlSelectQueryBlock select = (MySqlSelectQueryBlock)(((SQLQueryExpr)exp).getSubQuery().getQuery());
//			// 获取where对象
//			SQLExpr where = select.getWhere();
//			List<SQLSelectItem> selectList = select.getSelectList();
//			List<String> selectFieldStringList = new ArrayList<>();
//			// 遍历查询的字段，如果查询字段中有子查询 则加上租户ID查询条件
//			selectList.forEach(e -> {
//				if (e.getExpr() instanceof SQLQueryExpr) {
//					String newFieldSql = doSelectSql(String.valueOf(e.getExpr()));
//					SQLExpr subSelect = SQLUtils.toMySqlExpr(newFieldSql);
//					e.setExpr(subSelect);
//					LOG.info("sql select field have subQuery = {}", newFieldSql);
//				}
//				selectFieldStringList.add(String.valueOf(e));
//			});
//			String selectFieldString = String.join(", ", selectFieldStringList);
//			// 获取所查询的表
//			SQLTableSource from = select.getFrom();
//			StringBuffer newSql = new StringBuffer();
//			newSql.append("select").append(BLANK_STRING).append(selectFieldString).append(BLANK_STRING).append("from")
//					.append(BLANK_STRING);
//			// 判断是否有子查询
//			if (from instanceof SQLSubqueryTableSource) {
//				newSql.append("(");
//				String fromString = String.valueOf(from);
//				fromString = fromString.replace("(", "").replace(")", "");
//				String subQuery = doSelectSql(fromString);
//				LOG.info("sql from have subQuery = {}", subQuery);
//				newSql.append(subQuery).append(")").append(BLANK_STRING).append(appendWhere(where));
//				return newSql.toString();
//			}
//			// 获取表名
//			String tableName = String.valueOf(from);
//			newSql.append(tableName).append(BLANK_STRING);
//			newSql.append(appendWhere(where));
//			return newSql.toString();
//		}
//		return sql;
//	}
//
//	/**
//	 * 添加where条件
//	 *
//	 * @param where
//	 *     where语句
//	 * @return 修改后的where条件
//	 */
//	private String appendWhere(SQLExpr where) {
//		StringBuffer whereString = new StringBuffer();
//		whereString.append(SQL_FIELD_WHERE).append(BLANK_STRING);
//		// 如果where中包含子查询
//		if (where instanceof SQLInSubQueryExpr) {
//			// 获取子查询语句
//			String subQuery = String.valueOf(((SQLInSubQueryExpr)where).subQuery);
//			// 处理子查询语句
//			String newSubQuery = doSelectSql(subQuery);
//			String tempWhereString = String.valueOf(where);
//			tempWhereString = tempWhereString.substring(0, tempWhereString.indexOf("(")) + "(" + newSubQuery
//					+ tempWhereString.substring(tempWhereString.lastIndexOf(")"));
//			whereString.append(tempWhereString);
//			return whereString.toString();
//		}
//		// 获取当前租户ID
//		// String currentTenantId = String.valueOf(SessionUtils.getCurrentTenantId());
//		String currentTenantId = "2";
//		if (where != null) {
//			whereString.append(BLANK_STRING).append(TABLE_FIELD_TENANT_ID).append(SQL_FIELD_EQUAL)
//					.append(currentTenantId).append(SQL_FIELD_AND).append("(").append(SQLUtils.toMySqlString(where))
//					.append(")");
//		} else {
//			whereString.append(TABLE_FIELD_TENANT_ID).append(SQL_FIELD_EQUAL).append(currentTenantId);
//		}
//		return whereString.toString();
//	}

	@Override
	public PreparedStatementProxy connection_prepareStatement(FilterChain chain, ConnectionProxy connection, String sql)
			throws SQLException {
		LOG.info("new sql = {}", sql);
		return super.connection_prepareStatement(chain, connection, sql);
	}

}

