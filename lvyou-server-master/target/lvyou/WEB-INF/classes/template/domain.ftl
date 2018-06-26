package ${packageRoot}.domain;

import java.util.Date;
import ${packageRoot}.common.vo.PageVo;

/**
 * 
 */
public class ${tableClassName} extends PageVo{
	<#list list as columnbean>
		private ${columnbean.javaType} ${columnbean.name};
	</#list>
	<#list list as columnbean>
		public ${columnbean.javaType} get${columnbean.columnClassName}() {
			return ${columnbean.name};
		}
		public void set${columnbean.columnClassName}(${columnbean.javaType} ${columnbean.name}) {
			this.${columnbean.name} = ${columnbean.name};
		}
	</#list>
}
