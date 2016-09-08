require 'rails_helper'

describe ApplicationPolicy do
  subject { ApplicationPolicy }
  let(:user) { FactoryGirl.build(:user) }
  let(:admin) { FactoryGirl.build(:admin) }

  permissions :index? do
    it 'grants access to admin' do
      expect(subject).to permit(admin)
    end

    it 'grants access to user' do
      expect(subject).to permit(user)
    end
  end
end