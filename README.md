# API PIBaeta

* Spring Boot
* Thymeleaf
* MongoDB

# Prepara??o do Ambiente

db.papel.insert([{"_class" : "br.com.danielwisky.pibbaeta.models.Papel", "descricao" : "ROLE_ADMIN"}]);
db.papel.insert([{"_class" : "br.com.danielwisky.pibbaeta.models.Papel", "descricao" : "ROLE_USER"}]);

db.usuario.createIndex( { login : 1 }, { unique: true } );
db.usuario.createIndex( { email : 1 }, { unique: true } );

db.usuario.insert({
    "_class": "br.com.danielwisky.pibbaeta.models.Usuario",
    "nome": "Daniel",
    "login": "daniel",
    "email": "teste@teste.com.br",
    "senha": "$2a$10$bVVGBTJW.eotUJvxeZkEEuop69ZEuhFAyLBIBS9KGC2xwITVYVwGi",
    "status": "ATIVO",
    "papeis": [{"_class" : "br.com.danielwisky.pibbaeta.models.Papel","descricao" : "ROLE_ADMIN"}, {"_class" : "br.com.danielwisky.pibbaeta.models.Papel","descricao" : "ROLE_USER"}]
})