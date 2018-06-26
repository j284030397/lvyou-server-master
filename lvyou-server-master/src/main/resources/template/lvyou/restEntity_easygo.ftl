package ${packageRoot};
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
/*
* tableComment
*/
@Entity  
@Table(name="${tableName}") 
public class ${tableClassName}  extends BaseObject{
	private static final long serialVersionUID = -7681644943973061799L;
	
	public static final String T_NAME = "${tableName}";
	
<#list list as columnbean>
	public final static String C_${columnbean.colName? upper_case}="${columnbean.colTbName}";
</#list>

<#list list as columnbean>
	<#if (columnbean.PK)>
	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO)  
	@Column(name="${columnbean.colTbName}"<#if (columnbean.colDataType == 'String')>,length=${columnbean.colLength}</#if>)	 
	private ${columnbean.colDataType} ${columnbean.colName};  

		<#list forList as forField>
			<#if (forField.referField ==columnbean.colTbName&&forField.referenceTb==tableName)>
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "${forField.referenceClassTbFirstLowcase}")
	 private Set<${forField.fromClassTb}>  ${forField.fromClassTbFirstLowcase} = new HashSet<${forField.fromClassTb}>();
	 public Set<${forField.fromClassTb}> get${forField.fromClassTb}() {
        return  ${forField.fromClassTbFirstLowcase};
    }
    public void set${forField.fromClassTb}(Set<${forField.fromClassTb}>  ${forField.fromClassTbFirstLowcase}) {
        this.${forField.fromClassTbFirstLowcase} = ${forField.fromClassTbFirstLowcase};
    }

			</#if>
		</#list>

		<#if columnbean.foreignField ??>
			<#list  columnbean.foreignField as foreMap>  
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "${foreMap.foreignField}")
	private ${foreMap.referenceClassTb} ${foreMap.referenceClassTbFirstLowcase};	
	public ${foreMap.referenceClassTb} get${foreMap.referenceClassTb}() {
		return ${foreMap.referenceClassTbFirstLowcase};
	}
	public void set${foreMap.referenceClassTb}(${foreMap.referenceClassTb} ${foreMap.referenceClassTbFirstLowcase}) {
		this.${foreMap.referenceClassTbFirstLowcase} = ${foreMap.referenceClassTbFirstLowcase};
	}

			</#list>
		</#if>	
	<#else>		
		<#if columnbean.foreignField ??>
			<#list  columnbean.foreignField as foreMap>  
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "${foreMap.foreignField}")
	private ${foreMap.referenceClassTb} ${foreMap.referenceClassTbFirstLowcase};	
	public ${foreMap.referenceClassTb} get${foreMap.referenceClassTb}() {
		return ${foreMap.referenceClassTbFirstLowcase};
	}
	public void set${foreMap.referenceClassTb}(${foreMap.referenceClassTb} ${foreMap.referenceClassTbFirstLowcase}) {
		this.${foreMap.referenceClassTbFirstLowcase} = ${foreMap.referenceClassTbFirstLowcase};
	}

			</#list>
		<#else>	

	@Column(name="${columnbean.colTbName}"<#if (columnbean.colDataType == 'String')>,length=${columnbean.colLength}</#if>)	 
	private ${columnbean.colDataType} ${columnbean.colName};
		</#if>
	</#if>
	</#list>

	<#list list as columnbean>
	<#if columnbean.foreignField ??>
	<#else>
	public ${columnbean.colDataType} get${columnbean.colClassName}() {
		return ${columnbean.colName};
	}
	public void set${columnbean.colClassName}(${columnbean.colDataType} ${columnbean.colName}) {
		this.${columnbean.colName} = ${columnbean.colName};
	}
	</#if>
</#list>
}
