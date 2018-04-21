When("I buy a {string} with eid {string} from {string}") do |species, eid, seller|
  visit(AddAnimalPage) do |page|
    page.species = species
    page.eid = eid
    page.seller = seller
    page.save
  end
end

Then("the sheep with eid {string} is at the farm") do |eid|
  expect(visit(AnimalInventoryPage).animals).to include(eid)
end
