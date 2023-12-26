# day04



## formdata 服务器的开发

```txt

npm install express-formidable

const express = require('express'); 
const formidable = require('express-formidable') // 引入

const app = express();

app.use(formidable());  // 中间件




   if (req.method === 'POST') {
        username = req.body.username;
        password = req.body.password;
        if (req.fields) {
            username = req.fields.username;
            password = req.fields.password;
        }
    }
```

