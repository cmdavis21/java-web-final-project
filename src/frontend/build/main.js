//testing connection
console.log("Connected!");

// async await function for GET method
async function showAllInventory() {
    try {
      // fetching the saved inventory from clothing_store database
      const inventoryListResponse = await fetch("http://localhost:8080/api/inventory");
      const JSONList = await inventoryListResponse.json();
      console.log(JSONList);
  
      // DOM injecting HTML element to display JSON objects
  
      // access the #divContainer in the index.html
      const divContainer = document.getElementById("divContainer");
  
      // iterate over the JSONList array and extract ClothingItem.java model fields
      const formattedContent = JSONList.map(item => `${item.imageURL}` + `\n` + `${item.itemType}` + `\n` + `Category: ${item.category}` + 
      `\n` + `${item.description}` + `\n` + `Sizes: ${item.sizes}` + `\n` + `Colors: ${item.colors}` + `\n` + `Price: ${item.price}` + `\n` + 
      `Discounted? ${item.hasDiscount}` + `\n` + `Id: ${item.id}`);
      
      // set the container to hold the formatted content
      divContainer.textContent = formattedContent.join("\n\n");
    } catch (error) {
      console.log(error);
    }
} 
  
showAllInventory(); // run the function
  

// async await function for POST method
async function newProducts(event) {
    try {
        // prevent browser from reloading and losing data when form is submitted
        event.preventDefault();

        // access the HTML form elements
        const image = document.getElementById("imageURL");
        const itemType = document.getElementById("itemType");
        const sizes = document.getElementsByName("sizes[]");
        const selectedSizes = Array.from(sizes)
            .filter(size => size.checked)
            .map(size => size.value);
        const colors = document.getElementById("colors");
        const category = document.getElementById("category");
        const description = document.getElementById("description");
        const price = document.getElementById("price");
        const discount = document.getElementById("hasDiscount");

        // format the elements into a JSON object
        const JSONObject = [
            {
                imageURL: image.value,
                itemType: itemType.value,
                sizes: selectedSizes,
                colors: colors.value,
                category: category.value,
                description: description.value,
                price: price.value,
                hasDiscount: discount.value
            }
        ];

        // send the JSON object to the server
        await fetch("http://localhost:8080/api/inventory/newItem", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(JSONObject)
        });

        // clear the form inputs
        image.value = "";
        itemType.value = "";
        sizes.value = "";
        colors.value = "";
        category.value = "";
        description.value = "";
        price.value = "";
        discount.value = "";

    } catch (error) {
        console.log(error);
    }
}

// get the HTML form element
const form = document.getElementById("productForm");

// add an event listener to the form submit event
form.addEventListener("submit", newProducts);


// async await function for PUT method


// async await function for DELETE method