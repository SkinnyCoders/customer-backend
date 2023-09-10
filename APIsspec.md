# API Spec

## Get All Consumer

Endpoint : POST /api/v1/konsumen

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) : 

```json
{
    "data": [
        {
            "id": 8,
            "nama": "Ridho",
            "alamat": "Jl. RS. Fatmawati Raya No.1, RT.1/RW.7, Gandaria Utara, Kec. Kby. Baru",
            "kota": "Jakarta Selatan",
            "provinsi": "Daerah Khusus Ibukota Jakarta",
            "tgl_registrasi": "2023-09-10T08:33:59.000+00:00",
            "status": "non-aktif"
        },
        {
            "id": 9,
            "nama": "Ridho 1",
            "alamat": "Jl. RS. Fatmawati Raya No.1, RT.1/RW.7, Gandaria Utara, Kec. Kby. Baru",
            "kota": "Jakarta Selatan",
            "provinsi": "Daerah Khusus Ibukota Jakarta",
            "tgl_registrasi": "2023-09-10T09:43:55.000+00:00",
            "status": "aktif"
        }
    ],
    "message": "SUCCESS"
}
```

Response Body (Failed) :

```json
{
    "data": null,
    "message": "DATA_NOT_FOUND"
}
```

## Register Consumer

Endpoint : POST /api/v1/konsumen/register

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "nama": "Ridho 1",
  "alamat": "Jl. RS. Fatmawati Raya No.1, RT.1/RW.7, Gandaria Utara, Kec. Kby. Baru",
  "kota": "Jakarta Selatan",
  "provinsi": "Daerah Khusus Ibukota Jakarta"
}
```

Response Body (Success) :

```json
{
    "data": null,
    "message": "SUCCESS"
}
```

Response Body (Failed) :

```json
{
    "data": null,
    "message": "FAILED"
}
```

## Update Status Consumer

Endpoint : PATCH /api/v1/konsumen/status

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "id": 8,
  "status": "non-aktif"
}
```

Response Body (Success) :

```json
{
    "data": null,
    "message": "SUCCESS"
}
```

Response Body (Failed) :

```json
{
    "data": null,
    "message": "FAILED"
}
```

## Search Consumer By Name

Endpoint : GET /api/v1/konsumen/search?name={name}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
    "data": [
        {
            "id": 8,
            "nama": "Ridho",
            "alamat": "Jl. RS. Fatmawati Raya No.1, RT.1/RW.7, Gandaria Utara, Kec. Kby. Baru",
            "kota": "Jakarta Selatan",
            "provinsi": "Daerah Khusus Ibukota Jakarta",
            "tgl_registrasi": "2023-09-10T08:33:59.000+00:00",
            "status": "non-aktif"
        },
        {
            "id": 9,
            "nama": "Ridho 1",
            "alamat": "Jl. RS. Fatmawati Raya No.1, RT.1/RW.7, Gandaria Utara, Kec. Kby. Baru",
            "kota": "Jakarta Selatan",
            "provinsi": "Daerah Khusus Ibukota Jakarta",
            "tgl_registrasi": "2023-09-10T09:43:55.000+00:00",
            "status": "aktif"
        }
    ],
    "message": "SUCCESS"
}
```

Response Body (Failed, 404) :

```json
{
    "data": null,
    "message": "DATA_NOT_FOUND"
}
```

## Get Consumer By Status

Endpoint : GET /api/v1/konsumen/status/{status}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
    "data": [
        {
            "id": 8,
            "nama": "Ridho",
            "alamat": "Jl. RS. Fatmawati Raya No.1, RT.1/RW.7, Gandaria Utara, Kec. Kby. Baru",
            "kota": "Jakarta Selatan",
            "provinsi": "Daerah Khusus Ibukota Jakarta",
            "tgl_registrasi": "2023-09-10T08:33:59.000+00:00",
            "status": "non-aktif"
        },
        {
            "id": 9,
            "nama": "Ridho 1",
            "alamat": "Jl. RS. Fatmawati Raya No.1, RT.1/RW.7, Gandaria Utara, Kec. Kby. Baru",
            "kota": "Jakarta Selatan",
            "provinsi": "Daerah Khusus Ibukota Jakarta",
            "tgl_registrasi": "2023-09-10T09:43:55.000+00:00",
            "status": "aktif"
        }
    ],
    "message": "SUCCESS"
}
```

Response Body (Failed, 404) :

```json
{
    "data": null,
    "message": "DATA_NOT_FOUND"
}
```

## Delete Consumer

Endpoint : DELETE /api/v1/konsumen/deleted/{id}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
    "data": null,
    "message": "SUCCESS"
}
```

Response Body (Failed) :

```json
{
    "data": null,
    "message": "DATA_NOT_FOUND"
}
```
