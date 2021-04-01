# Assignment-backend-api

Read assignment instructions provided in pdf file.
<h1>Backend API</h1>
<h3>Maven command to build project </h3>
<ol>
<li> mvn clean : to clean the project</li>
<li>mvn package : to compile all the class and test cases </li>
</ol>

<h3>To run in command prompt </h3>
java -jar target/assignment-api.jar

<h3>Database Configuration</h3>
<p>For demo purpose used in-memory database</p>
<h4>http://localhost:8080/h2-consol</h4>
<table>
<tr>
    <td>JDBC URL </td>
    <td>jdbc:h2:mem:adyendb</td>
</tr>
<tr>
    <td>User Name</td>
    <td>sa</td>
</tr>
<tr>
    <td>Password</td>
    <td>password</td>
</tr>
</table>


<h3>Checking API using Postman </h3>
<h4>Create Projects </h4>
Http Method : Post <br/>
URL : <u>localhost:8080/projects</u> <br/>
<u>Body</u> <br>
{
"name": "test1",
"status":"IN_PROGRESS"
}

<h4>Update Projects </h4>
Http Method : Put <br/>
URL : <u>localhost:8080/projects/1</u> <br/>
<u>Body</u> <br>
{
"name": "test1 update",
}

<h4>Get All Projects </h4>
Http Method : GET <br/>
URL : <u>localhost:8080/projects</u> <br/>

