require 'sinatra'

get '/' do
  erb :index
end

get '/introduction' do
  erb :introduction
end

get '/history' do
  erb :history
end

get '/activities' do
  erb :activities
end

get '/gallery' do
  erb :gallery
end