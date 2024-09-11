db.createUser(
    {
        user: "root",
        pwd: "reymitech",
        roles: [
            {
                role: "readWrite",
                db: "shop-ecommerce"
            }
        ]
    }
);