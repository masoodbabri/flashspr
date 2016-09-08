require 'rails_helper'

RSpec.describe Award, type: :model do
  context 'create' do
    it 'creates an award' do
      expect(Award.create(name: 'award')).to be_truthy
    end
  end
end
