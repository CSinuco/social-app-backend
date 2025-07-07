ENDPOINTS

Método	Endpoint	Descripción
GET	/api/users	Obtener todos los usuarios
GET	/api/users/login/{iduser}	Consultar datos de un usuario (login)
POST	/api/users/register	Registrar un nuevo usuario
GET	/api/users/user/{id}/chats	Obtener lista de chats del usuario
GET	/api/messages/private	Mensajes privados entre dos usuarios
GET	/api/messages/group/{groupId}	Mensajes dentro de un grupo
POST	/api/messages	Enviar mensaje privado o grupal
