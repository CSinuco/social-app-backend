Método	Endpoint	Descripción
GET	/api/users	Obtener todos los usuarios
GET	/api/users/login/{iduser}	Consultar usuario por ID (login)
POST	/api/users/register	Registrar un nuevo usuario
GET	/api/users/user/{id}/chats	Obtener lista de chats del usuario
GET	/api/messages/private?userId1=...&userId2=...	Obtener mensajes privados entre dos usuarios
GET	/api/messages/group/{groupId}	Obtener mensajes dentro de un grupo
POST	/api/messages	Enviar un mensaje privado o grupal

📤 JSONs de ejemplo
🔹 Registro de usuario – /api/users/register
json
Copy
Edit
{
  "userId": "00003",
  "userName": "Laura",
  "userLastName": "Mejía",
  "userUniqueName": "lmejia",
  "email": "laura@example.com",
  "phone": "3115551234",
  "registrationDate": "2025-07-07",
  "locationCode": "C001"
}
🔹 Enviar mensaje privado – /api/messages
json
Copy
Edit
{
  "senderUserId": "00001",
  "receiverUserId": "00002",
  "groupId": null,
  "parentMessageId": null,
  "content": "Hola, ¿cómo estás?",
  "contentTypeName": "Texto"
}
🔹 Enviar mensaje grupal – /api/messages
json
Copy
Edit
{
  "senderUserId": "00001",
  "receiverUserId": null,
  "groupId": 1,
  "parentMessageId": null,
  "content": "¡Hola equipo del grupo!",
  "contentTypeName": "Texto"
}
