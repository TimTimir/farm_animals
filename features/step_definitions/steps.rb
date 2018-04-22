When("I buy a {string} with eid {string} from {string}") do |species, eid, seller|
  visit(BuyAnimalPage) do |page|
    page.species = species.upcase
    page.eid = eid
    page.seller = seller
    page.save
  end
end

Then("the sheep with eid {string} is at the farm") do |eid|
  expect(visit(AnimalInventoryPage).animals).to include(eid)
end

Given("a {string} with eid {string} exists on the farm") do |species, eid|
  request = { :species => 'SHEEP',
              :eid => 'abc' }
  RestClient.put "#{BASE_URL}/api/animals", request.to_json, {:content_type => :json}
end

When("the {string} with eid {string} is reported as dead") do |species, eid|
  pending # Write code here that turns the phrase above into concrete actions
end

Then("the {string} with eid {string} is no longer on the farm") do |species, eid|
  pending # Write code here that turns the phrase above into concrete actions
end
