Rails.application.routes.draw do

  devise_for :users
  root 'staffs#index'

  resources :report

  devise_scope :user do
    resources :staffs do
      resources :kudos
      member do
        get 'sndkudo'
        get 'erstaff'
      end
    end
  end

  get 'kudos/report',to: "kudos#report"
  get "angular_test", to: "angular_test#index"
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
