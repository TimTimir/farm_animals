class LoginPage
  include PageObject

  text_field(:username, :id => 'username')
  text_field(:password, :id => 'password')
  button(:login, :id => 'login')

  page_url :my_page_url

  def my_page_url
    "#{BASE_URL}/ui/login"
  end

end