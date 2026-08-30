from flask import Flask, render_template, request, redirect, url_for

app = Flask(__name__)

products = [
    {
        "id": 9492,
        "name": "phone",
        "price": 11,
        "image": "https://tse2.mm.bing.net/th/id/OIP.uM1uNMpEcJEJPkJR661xvAAAAA?r=0&rs=1&pid=ImgDetMain&o=7&rm=3",
        "details": "ddd"
    },
    

    

    
    
    



    ]

# =======================
# Routes
# =======================
@app.route("/")
def index():
    return render_template("products_template.html", products=products)

@app.route("/product/<int:product_id>")
def product_details(product_id):
    product = None
    for p in products:
        if p["id"] == product_id:
            product = p
            break

    return render_template("details_template.html", product=product)

@app.route("/add", methods=["GET", "POST"])
def add_product_page():
    if request.method == "POST":
        products.append({
            "id": len(products) + 1,
            "name": request.form["name"],
            "price": request.form["price"],
            "image": request.form["image"],
            "details": request.form["details"]
        })
        return redirect(url_for("index"))

    return render_template("add_product_template.html")

@app.route("/delete/<int:product_id>", methods=["POST"])
def delete_product(product_id):
    for p in products:
        if p["id"] == product_id:
            products.remove(p)
            break
    return redirect(url_for("index"))

if __name__ == "main":
    app.run(debug=True)

