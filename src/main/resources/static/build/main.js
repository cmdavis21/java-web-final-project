//testing connection
console.log("Connected!");

// async await function for GET method
async function showAllInventory() {
    try {
      // fetching the saved inventory from clothing_store db
      const inventoryListResponse = await fetch("http://localhost:8080/api/inventory");
      const JSONList = await inventoryListResponse.json();
      console.log(JSONList);
  
      // DOM injecting HTML element to display JSON objects
  
      // access the #divContainer in the index.html
      const divContainer = document.getElementById("divContainer");
  
      // iterate over the JSONList array and extract itemType and description
      const formattedContent = JSONList.map(item => `${item.itemType}` + `\n` + `${item.description}` + `\n` + `Id: ${item.id}`);
      
      // set the container to hold the formatted content
      divContainer.textContent = formattedContent.join("\n\n");
    } catch (error) {
      console.log(error);
    }
} 
  
showAllInventory(); // run the function
  

// async await function for POST methods
async function newProducts(event) {
    try {
        // prevent browser from reloading and losing data when form is submitted
        event.preventDefault();

        // access the HTML form elements
        const itemType = document.getElementById("itemType");
        const description = document.getElementById("description");

        // format the elements into a JSON object
        const JSONObject = [
            {
                itemType: itemType.value,
                description: description.value 
            }
        ];

        // send the JSON object to the server
        await fetch("http://localhost:8080/api/inventory/new", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(JSONObject)
        });

        // clear the form inputs
        itemType.value = "";
        description.value = "";

    } catch (error) {
        console.log(error);
    }
}

// get the HTML form element
const form = document.getElementById("productForm");

// add an event listener to the form submit event
form.addEventListener("submit", newProducts);

