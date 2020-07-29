if [$(docker container ls -q --filter name=mydb_c)!='']; then

    docker container stop mydb_c
    docker container rm mydb_c
fi

if [$(docker image ls -q --filter reference=mydb)!='']; then

    docker image rm mydb
fi

 docker build . -t mydb

 docker container run -d -p 9909:3306 --name mydb_c mydb
