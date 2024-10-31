# Contenido del archivo: /halloween-page/halloween-page/config.ru

require 'rack'
require 'rack/handler/puma'
require 'sinatra'

class HalloweenApp < Sinatra::Base
  set :public_folder, 'public'
  set :views, 'views'

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
end

run HalloweenApp.run!