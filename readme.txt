The program checks the "Orders XML files" folder for any files matching the orders##.xml pattern. 

Afterwards, I've used an SAX parser as it is more memory-efficient than DOM.
We sort the orders in descending order by their timestamp and proceed to store the products and suppliers into a Hashmap.

We then write the XML files into a separate folder, in accordance with the supplier output file requirements.