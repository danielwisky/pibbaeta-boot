# API PIBBaeta

* Spring Boot
* Thymeleaf
* MongoDB

# Preparação do Ambiente

```
db.usuario.createIndex( { login : 1 }, { unique: true } );
db.usuario.createIndex( { email : 1 }, { unique: true } );

db.usuario.insert({
    "_class": "br.com.danielwisky.pibbaeta.models.Usuario",
    "nome": "Administrador",
    "login": "admin",
    "email": "admin@admin.com.br",
    "senha": "$2a$10$bVVGBTJW.eotUJvxeZkEEuop69ZEuhFAyLBIBS9KGC2xwITVYVwGi",
    "status": "ATIVO",
    "papeis": [
        "ROLE_ADMIN",
        "ROLE_USER"
    ]
});

db.tipoProgramacao.insert({
    "_class": "br.com.danielwisky.pibbaeta.models.TipoProgramacao",
    "descricao": "Culto"
});

db.tipoProgramacao.insert({
    "_class": "br.com.danielwisky.pibbaeta.models.TipoProgramacao",
    "descricao": "Evento"
});

db.tipoProgramacao.insert({
    "_class": "br.com.danielwisky.pibbaeta.models.TipoProgramacao",
    "descricao": "PG"
});
```
