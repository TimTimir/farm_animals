# set CLICK_DUMMY to true to fake backend
CLICK_DUMMY = true

BASE_URL = "file://#{Dir.pwd}/features/support/click_dummy"
TMP_DIR = "#{Dir.pwd}/build/cucumber-tmp"

MEMBER_DB = "#{TMP_DIR}/members.yaml"

require 'page-object'
require 'page-object/page_factory'
require 'rspec-expectations'
require 'fileutils'

FileUtils.mkdir_p TMP_DIR
FileUtils.mkdir_p "build/features"
browser = Selenium::WebDriver.for :chrome


@@default_member_data = {
  :stephan => {
    :email => 'sns@caimito.net'
  }
}


Before do
  @browser = browser
end

After do |scenario|
  if (scenario.failed?)
    time = Time.now.strftime('%Y_%m_%d_%Y_%H_%M_%S_')
    name_of_scenario = time + scenario.name.gsub(/\s+/, "_").gsub("/","_")
    file_path = "#{Dir.pwd}/build/features/#{name_of_scenario}.png"
    @browser.save_screenshot file_path
  end
end

at_exit do
  browser.close
end

World(PageObject::PageFactory)
