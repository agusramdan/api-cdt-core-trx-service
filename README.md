# Cash Deposit Transfer: Core Transaction


## compile





## Menjalankan GraphQL

Jalankan aplikasi Spring Boot, lalu buka GraphiQL UI di:

---
http://localhost:8080/graphiql
---

### Query
---
query {
getTrxDepositById(id: "550e8400-e29b-41d4-a716-446655440000") {
id
token
status
amount
createdOn
}
}
---

### Mutation
---
mutation {
createTrxDeposit(input: {
token: "abc123",
signature: "sig123",
serviceTransactionId: "trx123",
serviceTransactionNo: "trxno123",
serviceProductId: "prod123",
serviceProductCode: "PC123",
serviceProductName: "Deposit Service",
amount: 10000.0
}) {
id
token
status
createdOn
}
}

---