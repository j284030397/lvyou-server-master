<#list list as row>
<tr><td>${row.code}</td><td>${row.animal}</td>
<td>${row.color}</td><td>${row.odd_even}</td><td>${row.home_wild}</td><td><#if row.boy_girl??> ${row.boy_girl} </#if></td> 
<td>${row.sky_earth}</td><td>${row.five_attri}</td><td>${row.end_number}</td>
</tr>
</#list>
