
# 📱 Social Messaging App - API REST

Este proyecto implementa una API REST para una aplicación de mensajería social utilizando Spring Boot y base de datos Oracle.

---

## 📚 Endpoints de la API

| Método | Endpoint                                                  | Descripción                                      |
|--------|-----------------------------------------------------------|--------------------------------------------------|
| `GET`  | `/api/users`                                              | Obtener todos los usuarios                       |
| `GET`  | `/api/users/login/{iduser}`                               | Consultar usuario por ID (login)                 |
| `POST` | `/api/users/register`                                     | Registrar un nuevo usuario                       |
| `GET`  | `/api/users/user/{id}/chats`                              | Obtener lista de chats del usuario               |
| `GET`  | `/api/messages/private?userId1=...&userId2=...`           | Obtener mensajes privados entre dos usuarios     |
| `GET`  | `/api/messages/group/{groupId}`                           | Obtener mensajes dentro de un grupo              |
| `POST` | `/api/messages`                                           | Enviar un mensaje privado o grupal               |

---

## 📤 JSONs de ejemplo

### 🔹 Registro de usuario – `POST /api/users/register`

```json
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
```

---

### 🔹 Enviar mensaje privado – `POST /api/messages`

```json
{
  "senderUserId": "00001",
  "receiverUserId": "00002",
  "groupId": null,
  "parentMessageId": null,
  "content": "Hola, ¿cómo estás?",
  "contentTypeName": "Texto"
}
```

---

### 🔹 Enviar mensaje grupal – `POST /api/messages`

```json
{
  "senderUserId": "00001",
  "receiverUserId": null,
  "groupId": 1,
  "parentMessageId": null,
  "content": "¡Hola equipo del grupo!",
  "contentTypeName": "Texto"
}
```

---

## 📝 Notas importantes

- `contentTypeName` debe coincidir con valores existentes en `SOCIAL_UD.CONTENT_TYPE.TYPE_DESCRIPTION` (Ej: `"Texto"`, `"Imagen"`, `"Video"`...).
- Todos los `userId` deben existir previamente en `SOCIAL_UD.SOCIAL_USER`.
- En mensajes grupales, `receiverUserId` debe ser `null`.
- Para login o consulta individual, se usa el `userId` exacto (ej. `"00001"`).

---

¡Proyecto completado con éxito! 🎯

