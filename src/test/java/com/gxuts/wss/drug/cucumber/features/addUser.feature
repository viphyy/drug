@addUser
Feature: 创建用户
In order 在系统中新增一个用户
As a 系统管理员
I want 系统能够对新用户进行保存
用户编号相同的用户被认为是相同用户,不允许创建;不按照系统规定（例如 以"NF"开头）定义编号,不允许创建

用户的属性：
|用户编号|用户名| 性别 | 
    
  Scenario Outline:添加新用户
    Given 系统中存在用户，该用户的编号为"NF0001" 
    When 添加一个新的用户时，该用户编号为"<userNo>"，用户名为"<userName>"
    And   保存这个用户
    Then <启用 or 未启用 or 停用>设置用户为未启用状态
    And 保存时提示<用户已经存在 or 用户保存成功>
    And 页面跳转到<添加用户页面 or 用户列表页面>
    
  Examples:
   |userNo|userName|password|启用 or 未启用 or 停用|用户已经存在 or 用户保存成功       |添加用户页面 or 用户列表页面|
   |NF0001| xx     |  123   |  未启用                              |      用户已经存在                       |       用户列表页面             |
   |NF0002| yy     |  123   |  未启用                              |      用户保存成功                       |       用户列表页面             |
   |NF0001| zz     |  123   |  未启用                              |      用户已经存在                       |       添加用户页面             | 