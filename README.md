# SimpleApi
Simple Java Api for JutsuMaster made with spring boot

just run build/libs/ to get your API up and running

### endpoints
- GET /timer/{id} : get {id} best timer
- POST /timer : saves a new timer record for {id} 

### POST body json format example
{ "id":1 , "time": 1.3 }

