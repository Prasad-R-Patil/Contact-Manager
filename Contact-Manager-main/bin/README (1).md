
# ContactHub
ContactHub is a web application designed to efficiently manage your contact information. It provides features for handling various aspects of your contacts, including:

Phone Numbers
Email Addresses
Social Media Profiles
Description
The application also includes notification features for birthdays and allows you to organize contacts into groups based on their relationships, such as:

Friends
Family
Professional
This grouping functionality helps you prioritize and manage your contacts based on their importance and relationship to you.



## API Reference



```http
  GET localhost:8080/home
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `/home` | `string` |  Show all the contact |



```http
  GET /home/user/profile
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|   `home/user/profile`  | `string` |  User profile and there basic information |


```http
  GET /home/user/profile/saveprofile
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|    `home/user/profile/saveprofile`   | `string` |  You can update user profile  |

#### contact 



```http
  GET /home/addcontact
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|    `home/addcontact`   | `string` | You can add new contact

```http
  GET /home/contact/update/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|    `home/contact/update/{id}`   | `string` |  You can update your contact


```http
  GET /home/contact/delete/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|    `home/contact/delete/{id}`   | `string` | delete your contact
## Authors

- [Git Hub -Prashant Netke](https://github.com/01prashu)

- [ Linkdein- Prashant Netke](https://www.linkedin.com/in/prashant-netke-b994a622b/)
## 🚀 About Me
I am a dedicated computer science student with a strong focus on C++, Java, and python. I have a solid understanding of Data Structures and Algorithms and hands-on experience with Spring Boot, Thymeleaf, and MySQL for web development. My skills also include HTML, CSS, and Bootstrap for creating responsive designs.

I am enthusiastic about applying my knowledge to real-world problems and am eager to learn and grow in the tech industry. I’m currently looking for opportunities to contribute to meaningful projects and expand my skills further. Feel free to check out my projects and connect with me for potential collaborations or internships!

