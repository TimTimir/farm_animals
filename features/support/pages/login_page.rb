class LoginPage
  include PageObject

  text_field(:username, :name => 'username')
  text_field(:password, :name => 'password')
  button(:login, :name => 'submit')

  page_url :my_page_url

  def my_page_url
    "#{BASE_URL}/login"
  end

end