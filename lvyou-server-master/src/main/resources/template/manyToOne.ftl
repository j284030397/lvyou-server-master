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

@Entity  
@Table(name="${tableName}") 
public class ${tableClassName}{
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
			
	//<!--change to oneToOne-->
	//@JoinColumn(name = "SpotSid") --JoinColum是关系发出表的表字段。是外键。它指向其它表的主键.(一般是当前类中的属性,)
	//这一段出现错误的原因主要在于：一对一关系，关联的是两个表的主键，而且两个表主键的名字是一样的，
	//1.一对一关系，全改为以一对多关系生成，
	//2.多在一中必须有一个外键。
	//3.如果多在一（方）中的外键是一（方）的主键，则运行生成表时会报错。需删除下面这段和一(方)的对应的一段，就不会报错。
	//4.生成的表是正确的，但是一对一的关系不对。
	//解决办法：将下面的关系调整为一对一关系[以oneToOne模版生成，再替换这一段。和OneToMany对应的一段]
	@ManyToOne
	@JoinColumn(name = "${foreMap.foreignField}")
	private ${foreMap.referenceClassTb} ${foreMap.referenceClassTbFirstLowcase};	
	public ${foreMap.referenceClassTb} get${foreMap.referenceClassTb}() {
		return ${foreMap.referenceClassTbFirstLowcase};
	}
	public void set${foreMap.referenceClassTb}(${foreMap.referenceClassTb} ${foreMap.referenceClassTbFirstLowcase}) {
		this.${foreMap.referenceClassTbFirstLowcase} = ${foreMap.referenceClassTbFirstLowcase};
	}
	//<!--change to oneToOne end-->

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
